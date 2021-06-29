package com.example.demo.p04;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	@Autowired
	private HttpSession session;

	@Before("execution(* *..*Controller.aspect03(..))")
	public void advice11(JoinPoint jp) {
		String name = (String)session.getAttribute("NAME");

		if (name == null) {
			System.out.println("ログインできていないよ！");
		}
	}

	//@Before("execution(* com.example.demo.p04.AOPController.index(..))")
	//@Before("execution(* com.example.demo.p04.AOPController.*(..))")
	//@Before("execution(* com.example.demo.p04.*Controller.*(..))")
//	@Before("execution(* *..*Controller.*(..))")
//	public void advice01(JoinPoint jp) {
//		System.out.println("前処理だよ！");
//		System.out.println(jp.getSignature());
//	}

//
//	@After("execution(* *..*Controller.*(..))")
//	public void advice02(JoinPoint jp) {
//		System.out.println("後処理だよ！");
//	}
//
//	@AfterReturning("execution(* *..*Controller.*(..))")
//	public void advice03(JoinPoint jp) {
//		System.out.println("正常に終了したよ！");
//	}
//
//	@AfterThrowing(value="execution(* *..*Controller.*(..))", throwing="e")
//	public void advice04(JoinPoint jp, Exception e) {
//		System.out.println("例外が発生したよ！");
//	}

//	@Around("execution(* *..*Controller.*(..))")
//	public Object advice05(ProceedingJoinPoint jp) throws Throwable {
//		System.out.println("前処理だよ！");
//
//		//Contollerのメソッドを実行
//		Object result = jp.proceed();
//
//		System.out.println("後処理だよ！");
//
//		return result;
//	}
}
