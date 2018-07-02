var skills = [];
var company = {id:0,name:"",contact:""};
var companyList = [];
var academic = {id:0, name:""};
var academicList = [];
$(document).ready(function() {
	
    $( "#slider-range" ).slider({
      range: true,
      min: 0,
      max: 100,
      values: [ 75, 300 ],
      slide: function( event, ui ) {
        $( "#salaryRange" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
      }
    });
    $( "#salaryRange" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
      " - $" + $( "#slider-range" ).slider( "values", 1 ) );
	  
	  
	  $.ajax({
		type: "GET",
        url: "/peopleware-app/api/getCompanyList",
		contentType: "application/json",
        dataType: "json",
		success: function(data){   
			  companyList=data.baseDTO.companyList;
			   for(var j=0; j<companyList.length; j++){
				var newOption = $('<option/>');
				newOption.text(companyList[j].name);
				newOption.attr('value',companyList[j].id);
				company.id = companyList[j].id;
				company.name=companyList[j].name;
				company.contact=companyList[j].contact;
			    $('#companyName').append(newOption);
			   }
            },
        failure: function(errMsg) {
               alert(errMsg);//handle it in a proper way
            }
		});
	  
	  $.ajax({
		type: "GET",
        url: "/peopleware-app/api/getAcademicDegreeList",
		contentType: "application/json",
        dataType: "json",
		success: function(data){   
				academicList = data.baseDTO.academicDegreeList;
			   for(var j=0; j<academicList.length; j++){
				var newOption = $('<option/>');
				newOption.text(academicList[j].name);
				newOption.attr('value',academicList[j].id);
				academic.id = academicList[j].id;
				academic.name=academicList[j].name;
			    $('#academicDegree').append(newOption);
			   }
            },
        failure: function(errMsg) {
               alert(errMsg);//handle it in a proper way
            }
		});
	
	$.ajax({
		type: "GET",
        url: "/peopleware-app/api/getTechnicalSkillList",
		contentType: "application/json",
        dataType: "json",
		success: function(data){    
		
		var techlist=data.baseDTO.technicalSkillList;		
			   for(var j=0; j<techlist.length; j++){
	
				var ss = '<label for="'+techlist[j].id+'">'+techlist[j].name+'</label> <select onchange="changeRating(this.options[this.selectedIndex].value,'+techlist[j].id+')"  id="rating"><option id="" name="" value=""></option>'+'<option id="'+techlist[j].id+'" name="'+techlist[j].name+'" value="1">1</option>'+'<option id="'+techlist[j].id+'" name="'+techlist[j].name+'" value="2">2</option>'+'<option id="'+techlist[j].id+'" name="'+techlist[j].name+'" value="3">3</option>'+'<option id="'+techlist[j].id+'" name="'+techlist[j].name+'" value="4">4</option>'+'<option id="'+techlist[j].id+'" name="'+techlist[j].name+'" value="5">5</option></select>'
		
			    $('#rate').append(ss);
				skillObject = {
					id: techlist[j].id,
//					name: techlist[j].name,
					rating: null
				}
				skills.push(skillObject);
		 }
	 },
        failure: function(errMsg) {
               alert(errMsg);//handle it in a proper way
            }
		});
	
	$('form').submit(function(event) {
        event.preventDefault(); // prevent this form from being submited
		
		var flag = false;
		
		for(var i=0; i<skills.length; i++){
		if(skills[i].rating!=null){
			flag = true;
		}			
		}
		if(!flag){
		return alert("Please select atleast one skill");
		}
		
        var offerJson =
		{	
			"company" : company,			
			"name"	: $(jobName).val(),
			"description"   : $(description).val(),
			"lowerSalaryRange": $( "#slider-range" ).slider( "values", 0 ),
			"upperSalaryRange": $( "#slider-range" ).slider( "values", 1 ),
			"workingTime": $(workingTime).val(),
			"academicDegree":academic,
			"jobTechnicalSkills":skills
		}
		
		$.ajax({
            type: "POST",
            url: "/peopleware-app/api/postJobOffer",
            data: JSON.stringify(offerJson),
            contentType: "application/json",
            dataType: "json",
            success: function(data){
                 alert("Job Posted Sucessfully.");//handle it in a proper way
				$('form')[0].reset();
            },
            failure: function(errMsg) {
               alert(JSON.stringify(errMsg));//handle it in a proper way
            }
        });
        return false;
    });  
	  
	  
	  
  } );
  
   function changeRating(rate,id){
		 skills[id - 1].rating = rate; 
	 }
	 
	function selectCompany(val){
		company.id = parseInt(val);
		company.name = 	companyList[company.id].name;
		company.contact = companyList[company.id].contact;
		}
	function selectAcademic(val){
		academic.id = parseInt(val);
		academic.name = academicList[academic.id].name;
	}	