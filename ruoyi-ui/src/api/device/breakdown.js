import request from "@/utils/request";

//查询故障列表
export function ListBreakdown(query){
  return request({
    url:"device/report/host/getHostList",
    method:"post",
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
