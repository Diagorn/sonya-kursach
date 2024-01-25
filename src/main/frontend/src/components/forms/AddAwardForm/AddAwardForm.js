import React, {useState} from "react";
import {alertError} from "../../../utils/ExceptionUtils";
import CreateButton from "../../UI/buttons/CreateButton/CreateButton";
import BackButton from "../../UI/buttons/BackButton/BackButton";
import AwardService from "../../../service/api/AwardService";

export default function AddAwardForm(props) {

    const [award, setAward] = useState({})

    function handleChange(e) {
        let {id, value} = e.target

        setAward(prevState => {
            return {
                ...prevState,
                [id]: value
            }
        })
    }

    function save() {
        AwardService.addAward(props.employeeId, award)
            .then(res => props.onAddAward(res.data))
            .catch(e => alertError(e))
    }

    return (
        <div className="container">
            <div className="row mt-5">
                <form noValidate={true}>
                    <div className="mb-3">
                        <label htmlFor="text" className="form-label">Текст награды</label>
                        <input type="text" className="form-control" id="text" value={award.text}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="giverOrganization" className="form-label">Выдавшая организация</label>
                        <input type="text" className="form-control" id="giverOrganization" value={award.giverOrganization}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="dateRecieve" className="form-label">Дата вручения</label>
                        <input type="date" className="form-control" id="dateRecieve" value={award.dateRecieve}
                               onChange={(e) => handleChange(e)}/>
                    </div>
                </form>
                <div className="mb-3">
                    <div className="me-2 d-inline-block">
                        <CreateButton btnCallback={save} className="mr-3"/>
                    </div>
                </div>
            </div>
        </div>
    )
}