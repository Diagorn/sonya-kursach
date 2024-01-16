import axios from "axios";
import {AWARD_API_URL} from "../constants";

export default class AwardService {

    static async getEmployeeAwards(employeeId) {
        return axios.get(`${AWARD_API_URL}/employee/${employeeId}`);
    }
}