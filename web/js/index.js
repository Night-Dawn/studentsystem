function initPages() {
    $.post("before",{
        page:$("#page").val()
    },null,"script");
}
function presPages() {
    $.post("after",{
        page:$("#page").val()
    },null,"script");
}
$(document).ready(function () {
    $("#creatediv").hide();
    $("#retrievediv").hide();
    $("#updatediv").hide();
});
function Create() {
    $.post("create",{
        stu_id:$("#stu_id").val(),
        stu_name:$("#stu_name").val(),
        stu_sex:$("#stu_sex").val(),
        stu_age:$("#stu_age").val(),
        stu_phone:$("#stu_phone").val(),
        stu_class:$("#stu_class").val(),
        stu_birth:$("#stu_birth").val(),
        stu_place:$("#stu_place").val(),
        stu_nation:$("#stu_nation").val(),
        stu_major:$("#stu_major").val(),
        page:$("#page").val()
    },null,"script");
    $("#creatediv").hide(500);
}
function showCreate() {
    $("#creatediv").show(500);
}
function deletedata() {
    $("input:checkbox:checked").each(function () {
        $.post("delete",{
            page:$("#page").val(),
            del_id:$(this).next("div").children("span").eq(0).text()
        },null,"script");
        $(this).next("div").remove();
        $(this).remove();

    });
}
function showRetrieve() {
    $("#retrievediv").show(500);
}
function Retrieve() {
    $.post("retrieve",{
        retrieve_id:$("#retrieve_id").val()
    },null,"script");
    $("#retrievediv").hide(500);
}
function Update() {
    $.post("update",{
        update_id:$("#update_id").val(),
        update_name:$("#update_name").val(),
        update_sex:$("#update_sex").val(),
        update_age:$("#update_age").val(),
        update_phone:$("#update_phone").val(),
        update_class:$("#update_class").val(),
        update_birth:$("#update_birth").val(),
        update_place:$("#update_place").val(),
        update_nation:$("#update_nation").val(),
        update_major:$("#update_major").val(),
        page:$("#page").val()
    },null,"script");
    $("#updatediv").hide(500);
}
function showUpdate() {
    $("#updatediv").show(500);
    $("input:checkbox:checked").each(function () {
        $("#update_id").val($(this).next("div").children("span").eq(0).text());
        $("#update_name").val($(this).next("div").children("span").eq(1).text());
        $("#update_sex").val($(this).next("div").children("span").eq(2).text());
        $("#update_age").val($(this).next("div").children("span").eq(3).text());
        $("#update_phone").val($(this).next("div").children("span").eq(4).text());
        $("#update_class").val($(this).next("div").children("span").eq(5).text());
        $("#update_birth").val($(this).next("div").children("span").eq(6).text());
        $("#update_nation").val($(this).next("div").children("span").eq(8).text());
        $("#update_major").val($(this).next("div").children("span").eq(9).text());
    });
}