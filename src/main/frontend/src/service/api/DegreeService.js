import axios from "axios";
import {DEGREE_API_URL} from "../constants";

export default class DegreeService {

    static async getAllDegrees() {
        return axios.get(DEGREE_API_URL);
    }
}