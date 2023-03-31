import request from "@/utils/request";

export function CameraCheck(query) {
  return request({
    url:"/device/vehicleId/camraListStatus",
    method:"get",
    params:query
  })
}
