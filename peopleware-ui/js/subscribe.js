var skills = [];
var academic = {id:0, name:""};
var academicList = [];
$(document).ready(function(){
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
		
        var userJson =
		{
			"firstName" : $(firstName).val(),
			"lastName" : $(lastName).val(),
			"contact" : $(contact).val(),
			"email"	: $(email).val(),
			"minimumSalary"	: parseInt($(minimumSalary).val()),
			"workingTime"   : $(workingTime).val(),
			"academicDegree": academic,
			"candidateTechnicalSkills": skills
		}
	
	
		$.ajax({
            type: "POST",
            url: "/peopleware-app/api/register",
            data: JSON.stringify(userJson),
            contentType: "application/json",
            dataType: "json",
            success: function(data){
                 alert("Candidate Subscribe sucessfully.");//handle it in a proper way
				 $('form')[0].reset();
            },
            failure: function(errMsg) {
               alert(errMsg);//handle it in a proper way
            }
        });
        return false;
    });
	
	
		$.ajax({
		type: "GET",
        url: "/peopleware-app/api/getTechnicalSkillList",
		contentType: "application/json",
        dataType: "json",
		success: function(data){    
		
		var techlist=data.baseDTO.technicalSkillList;		
			   for(var j=0; j<techlist.length; j++){
	
				var ss = '<label for="'+techlist[j].id+'">'+techlist[j].name+'</label> <select onchange="changeRating(this.options[this.selectedIndex].value,'+techlist[j].id+')"  id="rating" ><option id="" name="" value=""></option>'+'<option id="'+techlist[j].id+'" name="'+techlist[j].name+'" value="1">1</option>'+'<option id="'+techlist[j].id+'" name="'+techlist[j].name+'" value="2">2</option>'+'<option id="'+techlist[j].id+'" name="'+techlist[j].name+'" value="3">3</option>'+'<option id="'+techlist[j].id+'" name="'+techlist[j].name+'" value="4">4</option>'+'<option id="'+techlist[j].id+'" name="'+techlist[j].name+'" value="5">5</option></select>'
		
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
	
	});
 function changeRating(rate,id){
		 skills[id - 1].rating = rate; 
	 }
	 
	function selectAcademic(val){
		academic.id = parseInt(val);
		academic.name = academicList[academic.id].name;
	}