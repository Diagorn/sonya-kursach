import axios from "axios";
import {LESSON_API_URL} from "../constants";

export default class LessonService {
    static async getSchedule() {
        return axios.get(`${LESSON_API_URL}/schedule`)
    }

    static async getDepartmentSchedule(departmentId) {
        return axios.get(`${LESSON_API_URL}/schedule/${departmentId}`)
    }

    static async addLesson(addLessonRequest) {
        return axios.post(LESSON_API_URL, addLessonRequest)
    }
}