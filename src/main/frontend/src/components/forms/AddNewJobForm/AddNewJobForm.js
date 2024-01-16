import React, {useState} from "react";
import EmployeeJobService from "../../../service/api/EmployeeJobService";
import {alertError} from "../../../utils/ExceptionUtils";
import CreateButton from "../../UI/buttons/CreateButton/CreateButton";
import BackButton from "../../UI/buttons/BackButton/BackButton";

export default function AddNewJobForm(props) {

    const [job, setJob] = useState({})

    function handleChange(e) {
        let {id, value} = e.target

        setJob(prevState => {
            return {
                ...prevState,
                [id]: value
            }
        })
    }

    function save() {
        EmployeeJobService.addEmployeeJob(props.employeeId, job)
            .then(() => props.onAfterSave())
            .catch(e => alertError(e))
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <form noValidate={true}>
                    <div className="mb-3">
                        <label htmlFor="salary" className="form-label">Зарплата</label>
                        <input type="number" className="form-control" id="salary" value={job.salary}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="position" className="form-label">Должность</label>
                        <input type="text" className="form-control" id="position" value={job.position}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                </form>
                <div className="mb-3">
                    <div className="me-2 d-inline-block">
                        <CreateButton btnCallback={save} className="mr-3"/>
                    </div>
                    <div className="d-inline-block">
                        <BackButton to="/"/>
                    </div>
                </div>
            </div>
        </div>
    )
}