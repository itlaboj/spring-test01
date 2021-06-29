package com.example.demo.p04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPSample {

	private void showJoinPoint(String from, JoinPoint jp) {
		System.out.println(from + ":" + jp.getTarget().getClass().getSimpleName() + "." + jp.getSignature().getName());

		Object[] args = jp.getArgs();

		for (Object o : args) {
			System.out.println(from + ":" + o);
		}
	}

	@Before("execution(* com.example.demo.WebController*.test*(..))")
	public void aoptest01(JoinPoint jp) {
		showJoinPoint("Before", jp);

//		System.out.println("Before Check!!");
//		System.out.println(jp.getSignature());

	}

	@After("execution(* *..WebController*.test*(..))")
	public void aoptest02(JoinPoint jp) {
		showJoinPoint("After", jp);

//		System.out.println("After Check!!");
//		System.out.println(jp.getSignature());
	}

	@Around("execution(* *..WebController.test*(..))")
	public Object aoptest03(ProceedingJoinPoint pjp) throws Throwable {
		showJoinPoint("Around", pjp);

		//メソッド実行
		Object result = pjp.proceed();

		System.out.println("Result:" + result);

		return result;
	}


//	@AfterThrowing(value = "execution(* *..WebController*.test*(..))", throwing = "e")
//	public void aoptest03(JoinPoint jp, Exception e) {
//		System.out.println("After Check333!!");
//		System.out.println(jp.getSignature());
//	}

//	@Around("execution(* *..WebController.test*(*))")
//	public void aoptest03(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("Before Check333!!");
//
//		//メソッド実行
//		Object result = pjp.proceed();
//
//		System.out.println("After Check333!!");
//	}

	//	@Around("execution(* com.example.demo.WebController.test02(..))")
	//	public void aoptest02(JoinPoint jp) {
	//		System.out.println("Before Check222!!");
	//		System.out.println(jp.getSignature());
	//	}
}
