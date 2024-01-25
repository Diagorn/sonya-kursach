import axios from "axios";
import {AWARD_API_URL} from "../constants";

export default class AwardService {

    static async getEmployeeAwards(employeeId) {
        return axios.get(`${AWARD_API_URL}/employee/${employeeId}`);
    }

    static async addAward(employeeId, award) {
        console.log(award)
        return axios.post(`${AWARD_API_URL}/employee/${employeeId}`, award)
    }
}