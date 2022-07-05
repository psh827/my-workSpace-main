<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <title>회원가입 step2</title>
    <link rel="stylesheet" href="./css/normalize.css">
    <link rel="stylesheet" href="./css/default.css">
    <link rel="stylesheet" href="./css/style.css">
    <script type="text/javascript" src="./js/prefix.js"></script>
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/common.js"></script>
  </head>
  <body>
    <div id="wrap">
	   <div id="header">
	   		<jsp:include page="/incl/banner.jsp">
	   			<jsp:param name="subtitle" value='<%=URLEncoder.encode("mode007 : 자바빈즈", "UTF-8") %>' />
	   		</jsp:include>
	   </div>
      <div class="logo">
        <h1><a href=""></a></h1>
      </div>
      <form action="add_user.do" method="post">
        <table>
          <tr>
            <td>
              <h3>
                <label class="id" for="id">아이디</label>
              </h3>
              <input type="text" id="id" name="userId" >
            </td>
          </tr>
          <tr>
            <td>
              <h3>
                <label class="pw" for="pw">비밀번호</label>
              </h3>
              <input type="password" id="pw" name="passwd" >
              <span class="lock-a"></span>
            </td>
          </tr>
          <tr>
            <td>
              <h3>
                <label class="repw" for="repw">비밀번호 재확인</label>
              </h3>
              <input type="password" id="repw" name="repw" >
              <span class="lock-b"></span>
            </td>
          </tr>
          <tr>
            <td>
              <h3 id="name">
                <label for="user_name">이름</label>
              </h3>
              <input type="text" id="user_name" name="userName">
            </td>
          </tr>
          <tr>
            <td>
              <h3>
                <label class="year" for="year">생년월일</label>
              </h3>
              <div class="input-group">
                <input class="date" type="text" id="year" name="year" maxlength="4" placeholder="년(4자)" size="10">
                <select id="month" class="date" name="month">
                  <div class="month">
                    <option value="월">월</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                  </div>
                </select>
                <input class="date" type="text" id="date" name="date" maxlength="2" size="10" placeholder="일">
              </div>
            </td>
          </tr>
          <tr>
            <td>
              <h3>
                <label class="gender" for="gender">성별</label>
              </h3>
              <select id="gender" name="gender">
                <option value="sex">성별</option>
                <option value="male">남자</option>
                <option value="female">여자</option>
                <option value="none">선택안함</option>
              </select>
            </td>
          </tr>
          <tr>
            <td>
              <h3>
                <label for="email">이메일<span id="select-opt-text">(선택)</span></label>
              </h3>
              <input class="email" type="text" id="pre-email" name="pre-email"> @ <input class="email" type="text" id="back-email" name="back-email" value="">
              <select class="select-email" name="select-email">
                <option value="">선택하기</option>
                <option value="naver.com">naver.com</option>
                <option value="google.com">google.com</option>
                <option value="daum.net">daum.net</option>
              </select>
            </td>
          </tr>
          <tr>
            <td>
              <h3 id="ph-label">
                <label for="">휴대전화</label>
              </h3>
              <ul>
                <li>
                  <select id="local-number" name="local-number">
                    <option value="그레나다 +1 473">그레나다 +1 473</option>
                    <option value="그리스 +30">그리스 +30</option>
                    <option value="기니 +224">기니 +224</option>
                    <option value="기니비사우 +245">기니비사우 +245</option>
                    <option value="대한민국 +82" selected>대한민국 +82</option>
                  </select>
                </li>
                <li>
                  <input class="phone" type="tel" id="phone" name="phone" maxlength="11" pattern="[0-9]{11}" placeholder="전화번호 입력" required>
                  <button type="button">인증번호 받기</button>
                </li>
                <li>
                  <input class="certify" type="text" id="auth-num" name="auth-num" maxlength="4" placeholder="인증번호 입력하세요" disabled>
                </li>
              </ul>
            </td>
          </tr>
          <tr>
            <td>
              <input type="checkbox" id="JAVA" class="checkbox" name="concern" value="java">
              <label for="JAVA">JAVA</label>
              <input type="checkbox" id="Servlet/JSP" class="checkbox" name="concern" value="servlet/jsp">
              <label for="Servlet/JSP">Servlet/JSP</label>
              <input type="checkbox" id="EJB" class="checkbox" name="concern" value="ejb">
              <label for="EJB">EJB</label>
              <input type="checkbox" id="Android" class="checkbox" name="concern" value="android">
              <label for="Android">Android</label>
              <input type="checkbox" id="Spring" class="checkbox" name="concern" value="spring">
              <label for="Spring">Spring</label>
            </td>
          </tr>
        </table>
        <div class="register">
          <button type="submit">가입하기</button>
        </div>
      </form>
      <footer>
        <table>
          <tr>
            <td><a href="#">이용약관</a></td>
            <td><a href="#"><strong>개인정보처리방침</strong></a></td>
            <td><a href="#">책임의 한계와 법적고지</a></td>
            <td><a href="#">회원정보 고객센터</a></td>
          </tr>
        </table>
        <div class="g-last">
          <div class="s-logo"></div>
          <span>&nbsp;&nbsp;Copyright&nbsp;<a href="#"><strong>NAVER Corp.</strong></a>&nbsp;&nbsp;All Rights Reserved</span>
        </div>
   		<%@ include file="/incl/footer.jsp" %>
      </footer>
    </div>
  </body>
</html>
