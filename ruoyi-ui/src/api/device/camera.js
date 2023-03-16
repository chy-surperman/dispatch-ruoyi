import request from "@/utils/request";

//查询摄像头列表
export function ListCamera(query) {
  return request({
    url:"",
    method:"get",
    params:query
  })
}
