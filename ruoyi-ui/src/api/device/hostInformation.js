import request from "@/utils/request";

export function PickVehicle(query) {
  return request({
    url:"/device/device/listByParam",
    method:"get",
    params:query,
  })
}

export function Command(query) {
  return request({
    url:"/device/device/push",
    method:"post",
    data:query
  })
}
