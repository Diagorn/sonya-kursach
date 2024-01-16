import axios from "axios";
import {EMPLOYEE_JOB_API_URL} from "../constants";

export default class EmployeeJobService {

    static async addEmployeeJob(employeeId, newEmployeeJobRequest) {
        return axios.post(`${EMPLOYEE_JOB_API_URL}/${employeeId}/add`, newEmployeeJobRequest);
    }

    static async getEmployeeJobs(employeeId) {
        return axios.get(`${EMPLOYEE_JOB_API_URL}/employee/${employeeId}`)
    }
}