package com.varxyz.banking.domain;
/**
 * LackOfbalanceException은 출금 시 잔고에 대한 예외를 반드시 처리해야 한다고 생각합니다. 
 * 출금 잔고가 없는데 unchecked Exception으로 처리할 경우 사용자는 돈이 뽑히는 줄 알고 
 * 기다렸다가 비정상적인 종료를 맞이하기 때문에 checked Exception으로 지정해 조건에 맞지않으면
 * 예외메세지 출력 후 프로그램 종료를 알립니다.
 * 
 * @param msg
 * @author 빡상
 */
public class LackOfBalanceException extends Exception{
	public LackOfBalanceException(String msg) {
		super(msg);
	}
}
