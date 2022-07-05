package com.varxyz.jv251.exception;
/**
 * LacOfBalanceException과 비슷한 맥락으로 사용자가 기다리지않고, 비정상적인 종료를 만나지않게
 * throws로 던지지 않고 여기서 checked Exception을 설정해서 판단해야한다고 생각합니다.
 * 
 * 지금은 출금 입금 만을 다루고있기 때문에 출금가능에 대한 직관적인 표시가 
 * 되어야한다고 생각해서 checked Exception을 사용했습니다.
 * 
 * @param msg
 * @author 빡상
 */
public class OverdraftAmountException extends LackOfBalanceException{
	private double overdraftAvail;
	public OverdraftAmountException(String msg, double balance, double overdraftAvail) {
		super(msg);
		this.overdraftAvail = overdraftAvail;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + ", 사용 가능한 대월액은 " + overdraftAvail + " 입니다.";
	}
}
