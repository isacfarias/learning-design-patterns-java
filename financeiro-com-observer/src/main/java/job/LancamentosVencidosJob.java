package job;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import model.Lancamento;
import notifier.Notifier;
import repository.Lancamentos;

public class LancamentosVencidosJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		
		Lancamentos lancamentos = (Lancamentos) jobDataMap.get("lancamentos");
		Notifier notifier = (Notifier) jobDataMap.get("notificador");
		
		List<Lancamento> lancamentosVencidos = lancamentos.todosVencidos();
		notifier.novosLancamentosVencidos(lancamentosVencidos);
	}

}