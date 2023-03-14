import request from "@/utils/request";

//查询故障列表
export function ListBreakdown(query){
  return request({
    url:"device/faultUrl/list",
    method:"get",
    params:query
  })
}

//查询公司列表
export function ListCompanyName() {
  return request({
    url:"device/common/companyName",
    method:"get",
  })
}

//查询线路名
export function ListRouteName(){
  return request({
    url:"device/common/allRouteName",
    method:"get"
  })
}

//根据公司查询线路列表
export function ListRouteNameForCompany(query) {
  return request({
    url:"device/common/routeName",
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
export function f() {

}

//删除故障
export function deleteBreakdown(ids) {
  return request({
    url:"device/faultUrl"+ids,
    method:"delete"
  })
}
