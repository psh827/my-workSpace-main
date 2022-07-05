package jv200.mode008;

public class PrimeNum {
	   public String primeNum(int n) {
	      String answer = n + " = "; //초기 변수설정을해줌 지금 이것을 출력하면 n이 200이라면 200 = 이렇게 출력됨 나중에 문자를 더하기 위한 변수
	      int[] primeOfNotPrime = new int[n / 2];
	      int notPrimeIndex = 0;
	      //0 이하 제거
	      if(n < 1) {
	         return "0이하의 숫자는 불가.";
	      } else {
	         try {
	            if(isPrime(n)) { //n이 소수라면
	               answer = n + " 은 소수다!";
	            }else { //아니라면 예외발생
	               NotPrimeNumException e = new NotPrimeNumException("소수가 아니네?");
	               throw e;
	            }
	         } catch (NotPrimeNumException e) {
	            String eMessage = e.getMessage();
	            System.out.println(eMessage);
	            if(n >= 10000000) {
	               System.out.println("계산중입니다---------");               
	            }

	            int resultIndex = 0;
	            boolean[] arr = new boolean[n+1];
	              arr[0] = arr[1] = false;
	              for(int i=2; i<=n; i++) {
	                  arr[i] = true;
	              }
	              for(int i=2; i*i<=n; i++) {
	                  for(int j=i*i; j<=n; j+=i) {
	                      arr[j] = false;
	                  }
	              }
	              for(int i=0; i<=n; i++) {
	                  if(true == arr[i]) {
	                     primeOfNotPrime[notPrimeIndex++] = i;
	                  }
	              }
	              
	            int[] resultNum = new int[notPrimeIndex]; //n을 소수로 나눴을때의 소수를 저장하는 array.
	            int squareCnt = 1;
	            int squareIndex = 0;
	            while(n != 0) {
	               //while문을 돌면서 n을 나누는 숫자를 저장.
	               for(int i = 0; i < notPrimeIndex; i++) {
	                  if(n % primeOfNotPrime[i] == 0) {
	                     resultNum[resultIndex++] = primeOfNotPrime[i];
	                     n = n / primeOfNotPrime[i];
	                     break;
	                  }
	               }
	               //나눠진 n이 primeNum이라면 마지막에 n을 저장하고 종료
	               if(isPrime(n)) {
	                  if(n != 1) { //이 조건을 달지 않으면 n이 1일때 array마지막에 1이 들어가게 되어서 원하는 식이 안나옴.
	                     resultNum[resultIndex++] = n;                     
	                  }
	                  break;
	               }
	            }
	            
	            //reusltNum에 있는 소수들의 중복갯수를 알기위한 2차원배열 생성.
	            int[][] squareNum = new int[resultIndex][2];
	            //초기값을 먼저 지정해줌.
	            squareNum[squareIndex][0] = resultNum[0];
	            //for문으로 카운트
	            for(int i = 1; i < resultIndex;   i++) {
	               if(resultNum[i] == resultNum[i - 1]) { //지금 숫자와 전의 숫자를 비교해서 같으면 squareCnt에  +1
	                  squareCnt++;
	               } else if(resultNum[i] != resultNum[i - 1]) { //다르면 count숫자 저장과 index에 +1 시킨후 지금 숫자 저장.
	                  squareNum[squareIndex][1] = squareCnt;
	                  squareIndex++;
	                  squareNum[squareIndex][0] = resultNum[i];
	                  squareCnt = 1;
	               }
	            }
	            //for문이 종료된후 세어진 squareCnt를 배열에 저장해줘야함. 아니면 예를들어 200 = 2 X 2 X 2 X 5 X 5인데 5의 갯수가 저장되지않음.
	            squareNum[squareIndex][1] = squareCnt;
	            
	            //for문으로 출력
	            for(int i = 0; i <= squareIndex; i++) {
	               if(i != squareIndex) { //마지막인덱스가 아니라면 +를 붙여서 answer에 더하고
	                  answer += squareNum[i][0] + "^" + squareNum[i][1] + " X ";
	               } else if (i == squareIndex) { //마지막 인덱스라면 숫자들만 answer에 더한다.
	                  answer += squareNum[i][0] + "^" + squareNum[i][1];
	               }
	            }   
	         }
	      }
	      return answer;
	   }
	   
	   //n이 소수인지 아닌지 판단하는 method
	   public boolean isPrime(int num) {
	      boolean check = true;
	      for(int i = 2; i < num; i++) {
	         if(num % i == 0) {
	            check = false;
	            break;
	         }
	      }
	      return check;
	   }
	}