<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript" src="js/Chart.min.js"></script>
<div class="row">
	<div class="col-md-12">
		<div class="widget wlightblue">

			<div class="widget-head">
				<div class="pull-left"><span id="salesMonth">3</span>월 매출</div>
				<div class="clearfix"></div>
			</div>


			<div class="widget-content">
				<div class="padd">
					<canvas id="salesBarChart"></canvas>
					<div class="pull-center">
						<button>이전 달</button>
						<button>다음 달</button>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="widget wlightblue">

			<div class="widget-head">
				<div class="pull-left"><span id="categoryMonth">3</span>월 판매 추이</div>
				<div class="clearfix"></div>
			</div>

			<div class="widget-content">
				<div class="padd">
					<canvas id="categoryLine"></canvas>
					<div class="pull-center">
						<button>이전 달</button>
						<button>다음 달</button>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>

<script>
$(function() {
	var date = (new Date).getDate();
	var dates = [];
	var sales = [];
	
	for (var i=1; i<=date; i++) {
		dates.push(i);
		sales.push(Math.round(Math.random()*500));
	}
	
	var salesBarChart = new Chart($("#salesBarChart"), {
	    type: 'bar',
	    data: {
	        labels: dates,
	        datasets: [{
	            label: '매출액',
	            data: sales,
	            backgroundColor: 'rgba(54, 162, 235, 0.2)',
	            borderColor: 'rgba(54, 162, 235, 1)',
	            borderWidth: 1
	        }]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero:true,
	                    max: 500
	                },
	                scaleLabel: {
	               		display: true,
	                	labelString: "만원",
	                }
	            }],
	            xAxes: [{
	                scaleLabel: {
	               		display: true,
	                	labelString: "일",
	                }
	            }]
	        }
	    }
	});
});

$(function(){
	var date = (new Date).getDate();
	var dates = [];
	var datas = [[], [], []];
	
	for (var i=1; i<=date; i++) {
		dates.push(i);
		datas[0].push(Math.round(Math.random()*100));
		datas[1].push(Math.round(Math.random()*100));
		datas[2].push(Math.round(Math.random()*100));
	}
	
	var python = {
	    label: "파이썬",
	    data: datas[0],
	    lineTension: 0,
	    fill: false,
	    borderColor: 'red',
	    backgroundColor: 'transparent',
	    pointBackgroundColor: 'red',
	    pointRadius: 5,
	    pointHoverRadius: 10,
	    pointHitRadius: 10
	};
	
	var java = {
	    label: "자바",
	    data: datas[1],
	    lineTension: 0,
	    fill: false,
	    borderColor: 'purple',
	    backgroundColor: 'transparent',
	    pointBackgroundColor: 'purple',
	    pointRadius: 5,
	    pointHoverRadius: 10,
	    pointHitRadius: 10,
	};
	
	var oracle = {
	    label: "오라클",
	    data: datas[2],
	    lineTension: 0,
	    fill: false,
	    borderColor: 'blue',
	    backgroundColor: 'transparent',
	    pointBackgroundColor: 'blue',
	    pointRadius: 5,
	    pointHoverRadius: 10,
	    pointHitRadius: 10,
	};

	var categoryData = {
		labels: dates,
		datasets: [python, java, oracle]
	};

	var chartOptions = {
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
	};

	var lineChart = new Chart($("#categoryLine"), {
	  type: 'line',
	  data: categoryData,
	  options: chartOptions
	});
});
</script>