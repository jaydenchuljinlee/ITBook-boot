<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="sidebar">
	<div class="sidebar-dropdown"><a href="#">Navigation</a></div>
	<div class="sidebar-inner">
		<!--- Sidebar navigation -->
		<!-- If the main navigation has sub navigation, then add the class "has_submenu" to "li" of main navigation. -->
		<ul class="navi">
			<!-- Use the class nred, ngreen, nblue, nlightblue, nviolet or norange to add background color. You need to use this in <li> tag. -->

			<li id="adminMain" class="nred pageMove adminMain"><a href="#"><i class="fa fa-desktop"></i> 메인</a></li>
			<!-- Menu with sub menu -->
			<li class="has_submenu nlightblue adminMember adminSales">
				<a href="#">
					<!-- Menu name with icon -->
					<i class="fa fa-user"></i> 회원 / 매출 
					<!-- Icon for dropdown -->
					<span class="pull-right"><i class="fa fa-angle-right"></i></span>
				</a>
				<ul>
					<li id="adminMember" class="pageMove"><a href="#">회원</a></li>
					<li id="adminSales" class="pageMove"><a href="#">매출</a></li>
				</ul>
			</li>
			<li class="has_submenu nlightblue adminPay adminExchange adminRefund adminDelivery">
				<a href="#">
					<!-- Menu name with icon -->
					<i class="fa fa-th"></i> 구매 관리
					<!-- Icon for dropdown -->
					<span class="pull-right"><i class="fa fa-angle-right"></i></span>
				</a>
				<ul>
					<li id="adminPay" class="pageMove"><a href="#">결제 내역</a></li>
					<li id="adminRefund" class="pageMove"><a href="#">환불 내역</a></li>
					<li id="adminExchange" class="pageMove"><a href="#">교환 내역</a></li>
					<li id="adminDelivery" class="pageMove"><a href="#">배송 관리</a></li>
				</ul>
			</li>
			<li id="adminBookManage" class="nred pageMove adminBookManage"><a href="#"><i class="fa fa-book"></i> 도서</a></li>
			<li class="has_submenu nlightblue adminUsedBookManage adminUsedSellRequest">
				<a href="#">
					<!-- Menu name with icon -->
					<i class="fa fa-book"></i> 중고
					<!-- Icon for dropdown -->
					<span class="pull-right"><i class="fa fa-angle-right"></i></span>
				</a>
				<ul>
					<li id="adminUsedBookManage" class="pageMove"><a href="#">도서 관리</a></li>
					<li id="adminUsedSellRequest" class="pageMove"><a href="#">판매 신청 목록</a></li>
				</ul>
			</li>
			<li class="has_submenu nviolet adminSeminar adminOnLecture adminOffLecture adminLicenseSchedule adminLicenseBoard">
				<a href="#">
					<i class="fa fa-desktop"></i> 교육
					<span class="pull-right"><i class="fa fa-angle-right"></i></span>
				</a>
				<ul>
					<li id="adminSeminar" class="pageMove"><a href="#">세미나 관리</a></li>
					<li id="adminOnLecture" class="pageMove"><a href="#">온라인 강의 관리</a></li>
					<li id="adminOffLecture" class="pageMove"><a href="#">오프라인 강의 관리</a></li>
					<li id="adminLicenseSchedule" class="pageMove"><a href="#">자격증 일정 등록</a></li>
					<li id="adminLicenseBoard" class="pageMove"><a href="#">자격증 자료실</a></li>
				</ul>
			</li>
			<li class="has_submenu nviolet adminItNews adminColumn adminStudyRoomManage">
				<a href="#">
					<i class="fa fa-code"></i> 개발자 공간
					<span class="pull-right"><i class="fa fa-angle-right"></i></span>
				</a>
				<ul>
					<li id="adminItNews" class="pageMove"><a href="#">IT 뉴스</a></li>
					<li id="adminColumn" class="pageMove"><a href="#">칼럼</a></li>
					<li id="adminStudyRoomManage" class="pageMove"><a href="#">스터디룸 관리</a></li>
				</ul>
			</li>
			<li id="adminEvent" class="nred pageMove adminEvent"><a href="#"><i class="fa fa-certificate"></i> 이벤트</a></li>
			<li class="has_submenu nblue adminFaq adminAsk">
				<a href="#">
					<i class="fa fa-volume-control-phone"></i> 고객센터
					<span class="pull-right"><i class="fa fa-angle-right"></i></span>
				</a>
				<ul>
					<li id="adminFaq" class="pageMove"><a href="#">FAQ</a></li>
					<li id="adminAsk" class="pageMove"><a href="#">1:1 문의</a></li>
				</ul>
			</li> 
		</ul>
		<!--/ Sidebar navigation -->

		<!-- Date -->
		<div class="sidebar-widget">
			<div id="todaydate" class="hasDatepicker"><div class="ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all" style="display: block;"><div class="ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all"><a class="ui-datepicker-prev ui-corner-all" data-handler="prev" data-event="click" title="Prev"><span class="ui-icon ui-icon-circle-triangle-w">Prev</span></a><a class="ui-datepicker-next ui-corner-all" data-handler="next" data-event="click" title="Next"><span class="ui-icon ui-icon-circle-triangle-e">Next</span></a><div class="ui-datepicker-title"><span class="ui-datepicker-month">February</span>&nbsp;<span class="ui-datepicker-year">2018</span></div></div><table class="ui-datepicker-calendar"><thead><tr><th scope="col" class="ui-datepicker-week-end"><span title="Sunday">Su</span></th><th scope="col"><span title="Monday">Mo</span></th><th scope="col"><span title="Tuesday">Tu</span></th><th scope="col"><span title="Wednesday">We</span></th><th scope="col"><span title="Thursday">Th</span></th><th scope="col"><span title="Friday">Fr</span></th><th scope="col" class="ui-datepicker-week-end"><span title="Saturday">Sa</span></th></tr></thead><tbody><tr><td class=" ui-datepicker-week-end ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled">&nbsp;</td><td class=" ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled">&nbsp;</td><td class=" ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled">&nbsp;</td><td class=" ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled">&nbsp;</td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">1</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">2</a></td><td class=" ui-datepicker-week-end " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">3</a></td></tr><tr><td class=" ui-datepicker-week-end " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">4</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">5</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">6</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">7</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">8</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">9</a></td><td class=" ui-datepicker-week-end " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">10</a></td></tr><tr><td class=" ui-datepicker-week-end " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">11</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">12</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">13</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">14</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">15</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">16</a></td><td class=" ui-datepicker-week-end " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">17</a></td></tr><tr><td class=" ui-datepicker-week-end " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">18</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">19</a></td><td class=" ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today" data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default ui-state-highlight ui-state-active ui-state-hover" href="#">20</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">21</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">22</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">23</a></td><td class=" ui-datepicker-week-end " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">24</a></td></tr><tr><td class=" ui-datepicker-week-end " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">25</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">26</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">27</a></td><td class=" " data-handler="selectDay" data-event="click" data-month="1" data-year="2018"><a class="ui-state-default" href="#">28</a></td><td class=" ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled">&nbsp;</td><td class=" ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled">&nbsp;</td><td class=" ui-datepicker-week-end ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled">&nbsp;</td></tr></tbody></table></div></div>
		</div>
	</div>
</div>

<form id="pageFrm">
	<input type="hidden" id="pageName" name="pageName">
</form>

<!-- 사이드바 하이라이트 -->
<script type="text/javascript">
var pageName = "<c:out value="${param.pageName}"/>";

if (pageName === "") {
	$(".adminMain").addClass("open");
} else {
	$("." + pageName).addClass("open");
	$("#" + pageName).addClass("active");
}

</script>