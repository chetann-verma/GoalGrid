import { useState } from "react";
import axios from "axios";  
function AddChallenge({onChallengeAdded}) {
  
    const [month, setMonth] = useState('');
    const [description, setDescription] = useState('');

    const handleSubmit = async (e) => {
    e.preventDefault();
    try {
        await axios.post('http://localhost:8080/challenges', {month, description});
        setMonth('');
        setDescription('');
        onChallengeAdded();
    } catch (error) {
        console.error('Error adding challenges: ' , error); 
    }
    
    };
  
    return(
   <div className="card my-5 glass-form">
    <div className="card-header">
        Add New Challenge
    </div>
    <div className="card-body">
        <form onSubmit={handleSubmit}>
            <div className="mb-3">
                <label htmlFor="month" className="form-label">Month</label>
                <input type="text" className="form-control" placeholder="e.g., January" id="month" value={month} onChange={(e) => setMonth(e.target.value)} required />
            </div>
            <div className="mb-3">
                <label htmlFor="description" className="form-label">Description</label>
                <textarea className="form-control" placeholder="Describe the Challenge" id="description" value={description} onChange={(e) => setDescription(e.target.value)} required />
            </div>
            <button type="submit" className="btn submit-btn">Submit</button>
        </form>
    </div>
</div>
  );
}
export default AddChallenge;