let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-update").on("click", () => {
            this.boardUpdate();
        });
        $("#btn-delete").on("click", () => {
            this.delete();
        });
        $("#btn-reply-save").on("click", () => {
            this.replySave();
        });

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
    },
    delete: function (){
        let id = $("#id").text()

        $.ajax({
            type:"DELETE",
            url: "/api/board/"+id,
            dataType : "json"
        }).done(function (resp){
            alert("글 삭제가 완료 되었습니다.");
            location.href="/";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },

    replySave: function (){
        let data={
            userId: $("#userId").val(),
            boardId: $("#boardId").val(),
            content: $("#content").val()
        }
        $.ajax({
            type: "POST",
            url: `/api/board/${data.boardId}/reply`,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp){
            alert("댓글 등록이 완료되었습니다.");
            location.href="/";
        }).fail(function (error){
           alert(JSON.stringify(error))
        });
    },
    replyDelete: function (boardId,replyId){
        $.ajax({
            type:"DELETE",
            url: `/api/board/${boardId}/reply/${replyId}`,
            dataType : "json"
        }).done(function (resp){
            alert("댓글 삭제가 완료 되었습니다.");
            location.href="/";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },


}

index.init();