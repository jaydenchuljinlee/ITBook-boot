$(function() {
	tabSortable.init();
	tabSortable.initFn();
	
	navTab.init();
	navTab.initFn();
	
	navContent.init();
	navContent.initFn();
	
	main.init();
	main.initFn();
	
	chart.init();
	chart.initFn();
});

//네비게이션 sortable
var tabSortable = {
	$addTabBtn : null,	
	$newTabModal : null,
	
	$addContentBtn : null,
	$newContentModal : null,
	
	init : function() {
		this.$addTabBtn = $("#addTabBtn");
		this.$newTabModal = $("#newTabModal");
		
		this.$addContentBtn = $("#addContentBtn");
		this.$newContentModal  = $("#newContentModal");
		
		var tabs = $("#tabs").tabs();
		
		tabs.find(".ui-tabs-nav").sortable({
			axis: "x",
			stop: function() {
				tabs.tabs( "refresh" );
			}
		});
	},
	
	initFn : function() {
		var that = this;
		
		that.$addTabBtn.click(function() {
			var title = that.$newTabModal.find(".title").val();

			if (title === "") {
				alert("제목을 입력해주세요!");				
			} else {
				that.addNewTabFn();
			}
		});
		
		that.$addContentBtn.click(function() {
			var title = that.$newContentModal.find(".title").val();
			var url = that.$newContentModal.find(".url").val();
			
			if (title === "" || url === "") {
				alert("제목/URL을 입력해주세요!");				
			} else {
				var category = that.$newContentModal.find(".navCategory").val();

				that.addNewContentFn(category);
			}
			
		});
	},
	
	addNewTabFn : function() {
		//새로운 tab 생성
		var $tabs = $("#tabs");
		
		var order = $tabs.find(".tabsList li").length + 1;
		var title = this.$newTabModal.find(".title").val();
		var url = this.$newTabModal.find(".url").val();
		
		var newTab = 
			'<li data-url=' + url + ' class="ui-state-default ui-corner-top ui-sortable-handle" role="tab" tabindex="-1" aria-controls="tabs-' + order + '" aria-labelledby="ui-id-' + order + '" aria-selected="false" aria-expanded="false">\
				<a href="#tabs-' + order + '" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-5">' + title + '</a>\
			</li>';
		$tabs.find(".tabsList").append(newTab);
		
		var newTabDiv = 
			'<div id="tabs-' + order + '" aria-labelledby="ui-id-' + order + '" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-hidden="true" style="display: block;"></div>';
		$tabs.append(newTabDiv);
	    
		//새로 만든 탭을 작동시켜줌
		$tabs.tabs("refresh");
		
		this.$newTabModal.modal("toggle");
		
		this.$newTabModal.find(".title").val("");
		this.$newTabModal.find(".url").val("");
	},
	
	addNewContentFn : function(category) {
		//새로운 항목 생성
		var that = this;
		
		$("#tabs .tabsList li a").each(function(index) {
			var $this = $(this);
			
			if ($this.text().trim() === category) {
				var tabOrder = index + 1;
				console.log("order : " + tabOrder);
				
				var newPTag =  '<p data-url="' + that.$newContentModal.find(".url").val() + '">\
									<a href="#">' + that.$newContentModal.find(".title").val() + '</a>\
								</p>';
				
				$("#tabs-" + tabOrder).append(newPTag);
				
				that.$newContentModal.modal("toggle");
				
				that.$newContentModal.find(".title").val("");
				that.$newContentModal.find(".url").val("");
				
				return false;
			}
		});
	}
			
}

//네비 탭 우클릭
var navTab = {
	$updateTabBtn : null,
	$updateTarget : null,
	$updateTabModal : null,
	
	init : function() {
		this.$updateTabBtn = $("#updateTabBtn");
		this.$updateTabModal = $("#updateTabModal");
	},
	
	initFn : function() {
		var that = this;
		
		$.contextMenu({
		    selector: '.ui-sortable-handle', 
		    
		    callback: function(key, options) {
		    	var $this = $(this);
		    	
		    	if (key === "edit") {
		    		that.editFn($this);
		    		
		    		that.$updateTarget = $this;
		    	} else {
		    		//Delete 클릭
		    		that.deleteFn($this);
		    	}
		    },
		    
		    items: {
		        "edit": {name: "Edit", icon: "edit"},
		        "delete": {name: "Delete", icon: function(){
		            return 'context-menu-icon context-menu-icon-quit';
		        }}
		    }
		});
		
		this.$updateTabBtn.click(function() {
			that.updateFn();
		});
	},
	
	editFn : function($target) {
		var title = $target.text().trim();
		var url = $target.data("url");
		
		this.$updateTabModal.find(".title").val(title);
		this.$updateTabModal.find(".url").val(url);
		
		this.$updateTabModal.modal("toggle");
	},
	
	updateFn : function() {
		
		var title = this.$updateTabModal.find(".title").val();
		var url = this.$updateTabModal.find(".url").val();
		
		this.$updateTarget.find("a").text(title);
		this.$updateTarget.data("url", url);
		
		this.$updateTabModal.modal("toggle");
	},
	
	deleteFn : function($target) {
		$target.remove();
	}
}

//네비 항목 우클릭
var navContent = {
	$updateContentBtn : null,
	$updateTarget : null,
	$updateContentModal : null,
	
	init : function() {
		this.$updateContentBtn = $("#updateContentBtn");
		this.$updateContentModal = $("#updateContentModal");
	},
		
	initFn : function() {
		var that = this;
		
		$.contextMenu({
		    selector: '#tabs div p', 
		    
		    callback: function(key, options) {
		    	var $this = $(this);
		    	
		    	if (key === "edit") {
		    		that.editFn($this);
		    		
		    		that.$updateTarget = $this;
		    	} else {
		    		that.deleteFn($this);
		    	}
		    },
		    
		    items: {
		        "edit": {name: "Edit", icon: "edit"},
		        "delete": {name: "Delete", icon: function(){
		            return 'context-menu-icon context-menu-icon-quit';
		        }}
		    }
		});
		
		this.$updateContentBtn.click(function() {
			that.updateFn();
		});
	},
	
	editFn : function($target) {
		var title = $target.find("a").text().trim();
		var url = $target.data("url");
		
		this.$updateContentModal.find(".title").val(title);
		this.$updateContentModal.find(".url").val(url);
		
		this.$updateContentModal.modal("toggle");
	},
	
	updateFn : function() {
		
		var title = this.$updateContentModal.find(".title").val();
		var url = this.$updateContentModal.find(".url").val();
		
		this.$updateTarget.find("a").text(title);
		this.$updateTarget.data("url", url);
		
		this.$updateContentModal.modal("toggle");
	},
	
	deleteFn : function($target) {
		$target.remove();
	}
}

var chart = {
	visitorArr 	: null,
	joinArr 	: null,
	leaveArr 	: null,
	sellArr 	: null,
	dateArr		: null,
	$chartBtn	: null,
	
	chartOptions : {
		legend: {
			display: true,
			position: 'top',
			labels: {
				boxWidth: 80,
				fontColor: 'black'
			}
		},
		scales: {
			yAxes: [{
				ticks: {
					beginAtZero:true,
					max: 100
				}
			}]
		}
	},

	init : function() {
		this.visitorArr = [];
		this.dateArr = [];
		
		var date = new Date();
		date.setDate(date.getDate() - 7);
	
		for (var i=0; i<7; i++) {
			date.setDate(date.getDate() + 1);
			this.dateArr.push(date.getMonth() + 1 + "/" + date.getDate());
		}
		
		this.$chartBtn = $(".chartBtn");
	},
	
	initFn : function() {
		this.showVisitorChart();

		var that = this;
		
		this.$chartBtn.click(function() {
			var id = $(this).attr("id");
			
			if (id === "visitor") {
				that.showVisitorChart();
			} else if (id === "client") {
				that.showClientChart();
			} else {
				that.showSellChart();
			}
		});
	},
	
	getVisitor : function() {
		this.visitorArr = [];
		
		for (var i=0; i<7; i++) {
			this.visitorArr.push(Math.round(Math.random()*100));
		}

		return this.visitorArr;
	},
	
	getJoinArr : function() {
		this.joinArr = [];
		
		for (var i=0; i<7; i++) {
			this.joinArr.push(Math.round(Math.random()*100));
		}

		return this.joinArr;
	},
	
	getLeaveArr : function() {
		this.leaveArr = [];
		
		for (var i=0; i<7; i++) {
			this.leaveArr.push(Math.round(Math.random()*100));
		}

		return this.leaveArr;
	},
	
	getSellArr : function() {
		this.sellArr = [];
		
		for (var i=0; i<7; i++) {
			this.sellArr.push(Math.round(Math.random()*100));
		}

		return this.sellArr;
	},
	
	showVisitorChart : function() {
		$("#mainChartDiv").empty().append('<canvas id="mainChart"></canvas>');
		
		var visitor = {
			label : "방문자",
			data: this.getVisitor(),
		    lineTension: 0,
		    fill: false,
		    borderColor: 'red',
		    backgroundColor: 'transparent',
		    pointBackgroundColor: 'red',
		    pointRadius: 5,
		    pointHoverRadius: 10,
		    pointHitRadius: 10
		}
		
		var dataSets = {
			labels : this.dateArr,
			datasets : [visitor]
		};

		var lineChart = new Chart($("#mainChart"), {
			type: 'line',
			data: dataSets,
			options: this.chartOptions
		});
		
		return lineChart;
	},
	
	showClientChart : function() {
		$("#mainChartDiv").empty().append('<canvas id="mainChart"></canvas>');
		
		var join = {
			label : "가입자",
			data: this.getJoinArr(),
		    lineTension: 0,
		    fill: false,
		    borderColor: 'red',
		    backgroundColor: 'transparent',
		    pointBackgroundColor: 'red',
		    pointRadius: 5,
		    pointHoverRadius: 10,
		    pointHitRadius: 10
		};
		
		var leave = {
			label : "탈퇴자",
			data: this.getLeaveArr(),
		    lineTension: 0,
		    fill: false,
		    borderColor: 'blue',
		    backgroundColor: 'transparent',
		    pointBackgroundColor: 'blue',
		    pointRadius: 5,
		    pointHoverRadius: 10,
		    pointHitRadius: 10
		};
		
		var dataSets = {
			labels : this.dateArr,
			datasets : [join, leave]
		};

		var lineChart = new Chart($("#mainChart"), {
			type: 'line',
			data: dataSets,
			options: this.chartOptions
		});
		
		return lineChart;
	},
	
	showSellChart : function() {
		$("#mainChartDiv").empty().append('<canvas id="mainChart"></canvas>');
		
		var sell = {
			label : "판매",
			data: this.getSellArr(),
		    lineTension: 0,
		    fill: false,
		    borderColor: 'purple',
		    backgroundColor: 'transparent',
		    pointBackgroundColor: 'purple',
		    pointRadius: 5,
		    pointHoverRadius: 10,
		    pointHitRadius: 10
		};
		
		var dataSets = {
			labels : this.dateArr,
			datasets : [sell]
		};

		var lineChart = new Chart($("#mainChart"), {
			type: 'line',
			data: dataSets,
			options: this.chartOptions
		});
		
		return lineChart;
	}
};

var main = {
	$mainMenu : null,
	$setNaviOrderBtn : null,
	
	init : function() {
		this.$mainMenu = $(".mainMenu");
		this.$setNaviOrderBtn = $("#setNaviOrderBtn");
	},
	
	initFn : function() {
		var that = this;
		
		this.$mainMenu.click(function() {
			var url = $(this).data("url");
			
			location.href = url;
		});
		
		this.$setNaviOrderBtn.click(function() {
			that.setNaviOrder();
		});
	},
	
	setNaviOrder : function() {
		alert("적용되었습니다.");
	}
};