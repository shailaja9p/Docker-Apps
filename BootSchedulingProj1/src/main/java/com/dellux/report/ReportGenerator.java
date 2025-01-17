package com.dellux.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportGenerator {

	//@Scheduled(initialDelay = 2000, fixedDelay= 3000)
	//@Scheduled(fixedRate= 5000)
	public void showReport1() {
		System.out.println("Report1 Thread name "+Thread.currentThread().getName());
		System.out.println("Report1 start time"+new Date());
		try {
			Thread.sleep(5000);
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Report1 end time"+new Date());
	}
	//@Scheduled(fixedRate= 2000)
	public void showReport2() {
		System.out.println("Report2 Thread name "+Thread.currentThread().getName());
		System.out.println("Report2 start time"+new Date());
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Report2 end time"+new Date());
	}
	//@Scheduled(cron="15 * * * * *")
	//@Scheduled(cron="0 3 11 * * *")
	//@Scheduled(cron="43 40 11 * * *")
	//@Scheduled(cron="0 48 * * * *")
	//@Scheduled(cron="0 50,52 11 * * *")
	//@Scheduled(cron="59 53-55 11 * * *")
	//@Scheduled(cron="20 30 18 10 * *")
	//@Scheduled(cron="* 46 12 * * *")
	//@Scheduled(cron="20 * 17  * * *")
	
	// period of time
	
	//@Scheduled(cron="0/20 * * * * *")
	//@Scheduled(cron="0 13/2 * * * *")
	//@Scheduled(cron="30 10/5 * * * *")
	//@Scheduled(cron="30 * 16 * * *")
	//@Scheduled(cron="0/10 10/2 * * * *")
	//@Scheduled(cron="0 0 18 1/10 * *")
	//@Scheduled(cron="20 10 19 1/15 * *")
	//@Scheduled(cron="0 0 10 * * SUN")
	//@Scheduled(cron="0 0/20 * * * *")
//	@Scheduled(cron="0 0 * * * SAT,SUN")
	//@Scheduled(cron="0 0 * ? * SAT,SUN")
	//@Scheduled(cron="0 0 0/1 ? * SAT,SUN")
	@Scheduled(cron="0 19 19 L-29 * *")
	public void showReport3() {
		System.out.println("Report generated on "+new Date());
	}
}

