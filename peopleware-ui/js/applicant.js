﻿var techlist;
$(document).ready(function(){
		$.ajax({
		type: "GET",
        url: "/peopleware-app/api/getTechnicalSkillList",
		contentType: "application/json",
        dataType: "json",
		success: function(data){    	
		techlist=data.baseDTO.technicalSkillList;					
		 },
        failure: function(errMsg) {
               alert(errMsg);//handle it in a proper way
         }
		});

		setTimeout(function(){  
		$.ajax({
		type: "GET",
        url: "/peopleware-app/api/listAllCandidates",
		success: function(data){   
				
				var html = data.baseDTO.candidateList.map(function (element) {
					return '<tr><td>' + element.firstName +' '+ element.lastName+'</td>' 
					+ '<td>'+ element.academicDegree.name + '</td>' 
					+ '<td>'+ element.minimumSalary + '</td>' 
					+ '<td>'+ element.workingTime + '</td>' 
					+ '<td>'+ element.email + '</td>'
					+ '<td>'+ element.candidateTechnicalSkills.map(function(e){
					return " "+techlist[e.technicalSkillId-1].name }) + '</td>'
					+ '<td>'+ element.contact + '</td>'
					+ '<td>'+ '<button type="submit" class="btn btn-link" onclick="fetchJobs('+element.id+')">Offers</button></td></tr>'}).join('');

document.getElementById('applicantList').innerHTML = html;
			   

            },
        failure: function(errMsg) {
               alert(errMsg);//handle it in a proper way
            }
		});
		}, 1000);
});

function fetchJobs(id){
	$.ajax({
		type: "GET",
        url: "/peopleware-app/api/candidateJobOffers?candidateId="+id,
		contentType: "application/json",
        dataType: "json",
		success: function(data){    	
		$('#jobmodal').modal('show');

		var html = data.baseDTO.jobOfferList.map(function (element) {
					return '<tr><td>' + element.company.name+'</td>' 
					+ '<td>'+ element.name + '</td>' 
					+ '<td>'+ element.description + '</td>' 
					+ '<td>'+ '$' +element.lowerSalaryRange +' - '+ '$'+ element.upperSalaryRange + '</td>' 
					+ '<td>'+ element.workingTime + '</td>'
					+ '<td>'+ element.jobTechnicalSkills.map(function(e){
					return " "+techlist[e.technicalSkillId-1].name }) + '</td>'
					+ '<td>'+ element.academicDegree.name + '</td></tr>'}).join('');

document.getElementById('jobofferlist').innerHTML = html;
		
		 },
        failure: function(errMsg) {
               alert(errMsg);//handle it in a proper way
         }
		});
	
	
}