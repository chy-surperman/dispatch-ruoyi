import request from "@/utils/request";

//查询摄像头列表
export function ListCamera(query) {
  return request({
    url:"device/cameraList/list",
    method:"get",
    params:query
  })
}

//提交表单
export function OnSubmit(query) {
  return request({
    url:"device/cameraList",
    method:"post",
    data:query
  })
}

//删除摄像头
export function DeleteCamera(ids) {
  return request({
    url:"device/cameraList"+ids,
    method:"delete",
  })
}
