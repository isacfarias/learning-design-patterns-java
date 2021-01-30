import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import job.RotinaPedidosJob;
import listener.Listener;
import listener.impls.DepositoListener;
import listener.impls.FaturamentoListener;
import notifiers.Notifier;
import notifiers.impls.NotificadorPedidos;
import repository.PedidoFonte;
import repository.impls.PedidosXML;

public class RotinaImportaPedidos {

	public static void main(String[] args) throws SchedulerException, InterruptedException {
		Notifier notificador = new NotificadorPedidos();

		Listener faturamento = new FaturamentoListener(notificador);
		Listener deposito = new DepositoListener(notificador);

		JobDataMap jobDataMap = new JobDataMap();
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		jobDataMap.put("pedidos", new PedidosXML());
		jobDataMap.put("notificador", notificador);

		JobDetail job = newJob(RotinaPedidosJob.class)
				.setJobData(jobDataMap)
				.withIdentity("RotinaPedidosJob", "RotinaPedidosGroup")
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
