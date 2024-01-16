import axios from "axios";
import {DISCIPLINE_API_URL} from "../constants";

export default class DisciplineService {

    static async getAllMissingDisciplinesForEmployee(employeeId) {
        return axios.get(`${DISCIPLINE_API_URL}/employee/${employeeId}/missing`)
    }
}