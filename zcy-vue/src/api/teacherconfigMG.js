import axios from 'axios'
import {reqJson} from './axiosFun'
/**
 * 接口教师信息配置
 **/

// 教师信息配置-查询教师信息配置
export const TeacherConfigList = params => {
  return axios
    .post(
      '/teacher/list/?q=' + params.q)
    .then(res => res.data)
}

// 教师信息配置-新增教师信息配置
export const TeacherConfigAdd = params => {
  return reqJson('post', '/teacher/add', params)
}

// 教师信息配置-更新教师信息配置
export const TeacherConfigUpdate = params => {
  return reqJson('post', '/teacher/update_teacher_by_teacher_tid', params)
}

// 教师信息配置-删除教师信息配置
export const TeacherConfigDelete = params => {
  return axios
    .delete(
      '/teacher/delete_teacher_by_id/?id=' + params)
    .then(res => res.data)
}

// export const UserConfigDelete = params => {
//   return reqJson('post', '/api/demo/v1/delete_user_by_user_id', params)
// }
