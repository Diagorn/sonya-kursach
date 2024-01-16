import axios from "axios";
import {EMPLOYEE_API_URL} from "../constants";

export default class EmployeeService {
    
    static async getAllEmployees() {
        return await axios.get(EMPLOYEE_API_URL)
    }

    static async addNewEmployee(addEmployeeRequest) {
        return await axios.post(EMPLOYEE_API_URL, addEmployeeRequest)
    }

    static async getEmployeeByFio(fio) {
        return await axios.get(`${EMPLOYEE_API_URL}/fio/${fio}`)
    }

    static async getEmployeeById(id) {
        return await axios.get(`${EMPLOYEE_API_URL}/${id}`)
    }

    static async getEmployeesWithEndingContract() {
        return await axios.get(`${EMPLOYEE_API_URL}/contractEnding`)
    }

    static async changeEmployeeDegree(employeeId, newDegreeRequest) {
        await axios.post(`${EMPLOYEE_API_URL}/${employeeId}/degree`, newDegreeRequest)
    }

    static async editEmployee(editEmployeeRequest) {
        await axios.patch(EMPLOYEE_API_URL, editEmployeeRequest)
    }

    static async deleteEmployee(employeeId) {
        await axios.delete(`${EMPLOYEE_API_URL}/${employeeId}`)
    }

    static async getEmployeesByAgeGroup(ageCode) {
        return axios.get(`${EMPLOYEE_API_URL}/age/${ageCode}`)
    }

    static async getEmployeeDisciplinesById(employeeId) {
        return axios.get(`${EMPLOYEE_API_URL}/id/${employeeId}/disciplines`)
    }

    static async getEmployeesByDegreeId(degreeId) {
        return axios.get(`${EMPLOYEE_API_URL}/degree/${degreeId}`)
    }

    static async addDiscipline(employeeId, disciplineId) {
        return axios.post(`${EMPLOYEE_API_URL}/addDiscipline`, {
            employeeId: employeeId,
            disciplineId: disciplineId
        })
    }
}