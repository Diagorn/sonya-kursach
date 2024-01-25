import axios from "axios";
import {DISCIPLINE_API_URL} from "../constants";

export default class DisciplineService {

    static async getAllMissingDisciplinesForEmployee(employeeId) {
        return axios.get(`${DISCIPLINE_API_URL}/employee/${employeeId}/missing`)
    }

    static async getAll() {
        return axios.get(DISCIPLINE_API_URL)
    }

    static async getByEmployeeId(employeeId) {
        return axios.get(`${DISCIPLINE_API_URL}/employee/${employeeId}`)
    }
}