import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import job.LancamentosVencidosJob;
import listener.impls.EmailListener;
import listener.impls.SMSListener;
import notifier.Notifier;
import notifier.impls.NotificadorLancamentosVencidos;
import repository.Lancamentos;

public class Principal {

	public static void main(String[] args) throws Exception {
		Notifier notificador = new NotificadorLancamentosVencidos();
		
		EmailListener enviadorEmail = new EmailListener(notificador);
		SMSListener enviadorSms = new SMSListener(notificador);
		
		Lancamentos lancamentos = new Lancamentos();
		
		notificador.registrarListener(enviadorSms);

		JobDataMap jobDataMap = new JobDataMap();
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		jobDataMap.put("lancamentos", lancamentos);
		jobDataMap.put("notificador", notificador);

		JobDetail job = newJob(LancamentosVencidosJob.class)
				.setJobData(jobDataMap)
				.withIdentity("lancamentosVencidosJob", "lancamentosVencidosGroup")
				.build();

		CronTrigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.withSchedule(cronSchedule("0 * * * * ?"))
				.build();

		scheduler.scheduleJob(job, trigger);

		scheduler.start();

		Thread.sleep(220000);

		scheduler.shutdown(true);
	}
}