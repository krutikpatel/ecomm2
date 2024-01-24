package com.jsn.orderprocessor.orderprocessor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.jsn.orderprocessor.model.Order;

@Component
public class OrderProcessorWorker {
	Logger logger = LogManager.getLogger(OrderProcessorWorker.class);

	public void processOrder(Order order) {
		try {
			logger.info("[processOrders] processing orderId"+order.getId());
			//do time consuming task
			Thread.sleep(1000);
			logger.info("[processOrders] completed orderId"+order.getId());
		} catch (InterruptedException e) {
			//e.printStackTrace();
			logger.error("[processOrders] exception in sleep"+e);
		}
	}
}
