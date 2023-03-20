import request from "@/utils/request";

//查询故障列表
export function ListBreakdown(query){
  return request({
    url:"device/faultUrl/list",
    method:"get",
    params:query
  })
}

//获取故障详情
export function Breakdown(id) {
  return request({
    url:"device/faultUrl/"+id,
    method:"get",
  })
}

//故障表单提交
export function SubmitForm(query) {
  return request({
    url:"device/faultUrl",
    method:"post",
    data:query
  })
}

//删除故障
export function DeleteBreakdown(ids) {
  return request({
    url:"device/faultUrl/"+ids,
    method:"delete"
  })
}

