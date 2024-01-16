import axios from "axios";
import {DEPARTMENT_API_URL} from "../constants";

export default class DepartmentService {

    static async getAll() {
        return axios.get(DEPARTMENT_API_URL)
    }
}