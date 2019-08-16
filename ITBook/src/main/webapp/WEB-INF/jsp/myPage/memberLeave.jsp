<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>회원탈퇴</title>
<script src="js/jquery.min.js" type="text/javascript"></script>

<style type="text/css">
/* 팝업공통속성 */
#pop_wrap { font-size:12px; font-family:"돋움"; color:#666; margin:0; padding:0; padding:25px; width:380px; background:#fff; }
#pop_wrap a { text-decoration:none; color:#666; }
#pop_wrap a:hover { color:#DC2626; }
#pop_wrap li { list-style:none; }
#pop_wrap button,
select { vertical-align:middle; border:none; }
#pop_wrap.w600 { width:550px; }
#pop_wrap p.tit_bar_pnt button { text-indent:-1000em; display:inline-block; *display:inline;
*zoom:1;
height:20px; margin:0; padding:0; float:right; background-position:right top; height:20px; width:20px; }
p.tit_bar_pnt { height:20px; border-bottom:1px solid #000; margin:0; padding-bottom:8px; }
p.tit_bar_pnt span { text-indent:-1000em; display:inline-block; *display:inline;
*zoom:1;
height:20px; margin:0; padding:0; float:left; }
p.tit_bar_pnt span.leave { width:120px; background-position:0 -120px; } /*회원탈퇴*/
p.btn_wrp { text-align:center; margin:15px 0 0 0; }
#pop_wrap button { border:none; cursor:pointer; font-weight:bold; letter-spacing:-1px; display:inline-block; *display:inline;
*zoom:1;
margin:0 3px }
#pop_wrap button.ok { width:90px; height:30px; background-position:right top; }
#pop_wrap button.cancel { width:90px; height:30px; background-position:left -210px; }
p.lil_tit { background-position:-338px 3px; padding:0 0 0 12px; margin-bottom:-5px; }
p.lil_tit span {display:inline-block; *display:inline;
*zoom:1;
height:13px; }
p.lil_tit span.userinfo { width:83px; background-position:right -100px; } /*회원정보확인*/
ul.gray_box { padding:12px; background:#f5f5f5; border:1px solid #e2e1dd; line-height:20px; position:relative; }
ul.gray_box li { padding-left:10px; }
#pop_wrap table { width:100%; padding:0; border-top:1px solid #BCBCB8; border-bottom:1px solid #bcbcb8; margin-top:15px; }
#pop_wrap table th { background:#F5F5F5; color:#999999; padding:10px 15px; text-align:left; border-bottom:1px solid #E1E1E1; width:90px; }
#pop_wrap table td { padding:10px 5px 10px 10px; border-bottom:1px solid #E1E1E1; color:#666666; }

.dl_myrest { display:block;border-bottom:1px solid #eaeaea; padding-left:25px;}
.dl_myrest ul {width:313px;padding:30px 0 20px 0;color: #ee3524;}
.dl_myrest ul li {height:20px;line-height:20px;padding:5px 0;text-align:right;}
.dl_myrest strong {float:left;color:#444;font-size:12px;}
.dl_myrest a.btn_more{display:inline-block;margin-top:-2px;margin-left:10px;vertical-align:top;text-align:right;}
#pop_wrap .dl_myrest dd a {color:#ee3524; margin-left:10px;}
.f11 {font-size:11px; text-align:right; padding:5px 0; color:#999}
.ol_terms {margin:20px 0 0 0; padding-left:20px; color:#898989; font-size:11px; border-bottom:1px solid #bcbcbc;}
#pop_wrap .ol_terms li {list-style:decimal; margin-bottom:8px;}
.p_agreement {padding:7px 20px 30px;}
.callcenter {width:175px; height:20px; float:right; margin-bottom:30px;}
table th {
	font-size: 80%;
}
</style>
</head>

<body>
<!--회원 탈퇴 -->
<div id="pop_wrap" class="w600" style="border: 1px solid black;">
	<ul class="gray_box">
		<li>회원 탈퇴를 하실 경우 회원님의 모든 정보가 삭제 되니 신중하게 결정하셔서 신청해 주세요.</li>
		<li><strong>탈퇴하신 계정의 아이디는 5일 동안 동일한 ID로 가입이 불가능</strong> 합니다.</li>
	</ul>
	<div>
		<table cellspacing="0">
			<tr>
				<th>잔여 마일리지</th>
				<td>1000</td>
			</tr>
			<tr>
				<th>배송 중인 상품</th>
				<td>0</td>
			</tr>
		</table>
		<p class="f11">* 잔여마일리지는 탈퇴와 함께 삭제되며 환불되지 않습니다.</p>
		<ol class="ol_terms">
			<li>회원 탈퇴 완료 후 잔여 마일리지는 모두 삭제되며 환불되지 않습니다.</li>
			<li>회원탈퇴 신청 즉시 회원전용 서비스의 이용이 불가능합니다.</li>
			<li>회원탈퇴 이후에는 게시물 편집, 삭제가 불가능하므로, 게시물을 편집하거나 삭제하기 바라시는 경우 게시물 편집/삭제 후 회원탈퇴를 해주시기 바랍니다</li>
			<li>회원탈퇴 신청 후 신청 취소를 원하시면 5일 이내에 해주시기 바랍니다. 5일 이후에는 회원탈퇴가 완료되어 해당 계정에 대한 모든 정보는 삭제되며 복원이 불가능 합니다. 또한 기존의 계정정보 보호를 위해 탈퇴 신청 후 5일 동안은 재가입이 제한됩니다.</li>
			<li>단 [전자상거래등에서의소비자보호에관한법률], [통신비밀보호법], [정보통신망이용촉진및정보보호에관한법률] 등 법률에 근거하여 거래 관련 권리의무관계의 확인 등을 이유로 일정기간 그 정보를 보유하여야 할 필요가 있을 경우에는 일정기간 동안 그 정보를 보유합니다.</li>
		</ol>
	</div>
	<p class="lil_tit" style="margin-top:20px;">
		<span class="userinfo" id="withdraw_error">
		<span class="hidden">회원 정보 확인</span>
		</span>
	</p>
	<table cellspacing="0">
		<tr>
			<th>아이디</th>
			<td>
				test
				<input type="hidden" id='u_id' value='test' class="w140" />
				<input type="hidden" id="uhs" name="uhs" class="w140" />
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" id="withdraw_upw" name="withdraw_upw" class="w140" />
				<span id="pwdError"></span>
			</td>
		</tr>
		<tr>
			<th class="nbd">이름</th>
			<td class="nbd">
				<input type="text" id="withdraw_uname" name="withdraw_uname" class="w140" />
				<span id="nmError"></span>
			</td>
		</tr>
	</table>
	<p class="btn_wrp">
		<button id="withdrawConfirmBtn" class="ok" style="border: 1px solid black;">
			<span class="hidden">확인</span>
		</button>
		<button class="cancel" onclick="window.close();" style="border: 1px solid black;">
			<span class="hidden">취소</span>
		</button>
	</p>
</div>
<script type="text/javascript">
	$(function() {
		$("#withdrawConfirmBtn").click(function() {
			alert("탈퇴처리 되었습니다.\n그동안 이용해주셔서 감사합니다.");
			opener.location.href = "main.do";
			window.close();
		});
	});
</script>
</body>
</html>
