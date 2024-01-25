import axios from "axios";
import {GROUP_API_URL} from "../constants";

export default class GroupService {

    static async getAll() {
        return axios.get(GROUP_API_URL)
    }
}