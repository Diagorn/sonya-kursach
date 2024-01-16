import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import EmployeeJobService from "../service/api/EmployeeJobService";
import {parseDate} from "../utils/DateUtils";
import EmployeeJobTable from "../components/job/EmployeeJobTable/EmployeeJobTable";
import AddNewJobForm from "../components/forms/AddNewJobForm/AddNewJobForm";

export default function EmployeeJobHistoryPage() {

    const params = useParams()
    const [jobs, setJobs] = useState([])

    useEffect(() => {
        refreshJobs()
    }, [])

    function refreshJobs() {
        EmployeeJobService.getEmployeeJobs(params.employeeId)
            .then(res => setJobs(res.data.sort(function (a, b) {
                return parseDate(a.dateStart) - parseDate(b.dateStart)
            })))
            .catch(e => console.log(e))
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <h1 className="display-3">История работ сотрудника</h1>
            </div>
            <div className="mb-3">
                <EmployeeJobTable jobs={jobs}/>
            </div>
            <div className="mb-3">
                <AddNewJobForm employeeId={params.employeeId} onAfterSave={refreshJobs}/>
            </div>
        </div>
    )
}