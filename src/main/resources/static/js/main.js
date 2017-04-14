var month = [];
var week = [];
var date = new Date();
var currentDate = date.toDateString();
date.setDate(1);
var day = date.getDay();
for (var i = 1; i <= 30+day; i++) {
	if (i <= day) {
		week.push('');
	}
	else {
		week.push(i-day);
	}
	if (i % 7 == 0) {
		month.push(week);
		week = [];
	}
}
month.push(week);

var app = new Vue({
	el: '.container',
	data: {
		items: month,
		nowDate: currentDate
	}
});