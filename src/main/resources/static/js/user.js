let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        }),
        $("#btn-update").on("click", () => {
            this.userUpdate();
        })

    },

    save: function () {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        }
        $.ajax({
            type: "POST",
            url:"/auth/joinProc",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp){
           alert("회원가입 완료");
           location.href="/"
        }).fail(function (error){
            alert(JSON.stringify(error))
            // alert("회원가입 실패");
        });
    },
    userUpdate: function (){
        let data= {
            id: $("#id").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        }
        $.ajax({
            type:"PUT",
            url: "/user",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType : "json"
        }).done(function (resp){
           alert("회원 정보가 업데이트 되었습니다.");
           location.href="/";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
}

index.init();