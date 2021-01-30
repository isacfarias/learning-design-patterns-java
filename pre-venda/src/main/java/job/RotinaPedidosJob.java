package job;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import model.Pedido;
import notifiers.Notifier;
import repository.PedidoFonte;

public class RotinaPedidosJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();

		PedidoFonte importaPedidos = (PedidoFonte) jobDataMap.get("pedidos");
		Notifier notifier = (Notifier) jobDataMap.get("notificador");

		List<Pedido> pedidos = importaPedidos.pedidos();
		notifier.addPedidos(pedidos);

	}

}
