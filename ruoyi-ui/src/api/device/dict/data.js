import request from "@/utils/request";

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

//查询自编号
export function SelfNum(query) {
  return request({
    url:"device/common/vehicesByRouteName",
    method:"get",
    params:query
  })
}
