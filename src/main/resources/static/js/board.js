let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        })
        $("#btn-update").on("click", () => {
            this.boardUpdate();
        })

    },

    save: function () {
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        }
        $.ajax({
            type:"POST",
            url:"/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp){
            alert("글쓰기가 완료되었습니다.");
            location.href="/";
        }).fail(function (error){
           alert(JSON.stringify(error))
        });

    },

    boardUpdate: function (){
        let data= {
            id: $("#id").val(),
            title: $("#title").val(),
            content: $("#content").val()
        }
        $.ajax({
            type:"PUT",
            url: "/api/board/"+ data.id,
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType : "json"
        }).done(function (resp){
            alert("글 수정이 완료 되었습니다.");
            location.href="/";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }

}

index.init();