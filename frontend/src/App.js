import { useEffect, useState } from 'react';
import ChallengesList from './components/ChallengesList';
import axios from 'axios';
import AddChallenge from './components/AddChallenge';
import 'bootstrap/dist/css/bootstrap.min.css';



function App() {

  const [challenges ,setChallenges] = useState([
    {id:1 , month:'January', description:'Learn React'},
    {id:2 , month:'February', description:'Learn Python'}
  ]);


  useEffect(() => {
  
  fetchChallenges();
}, []);

const fetchChallenges = async () => {
  try {
    const response = await axios.get('http://localhost:8080/challenges');
    setChallenges(response.data);
    
  } catch (error) {
    console.error('Error fetching challenges: ' , error);
  }
  }

const handleChallengeAdded = () => {
  fetchChallenges();
};
  return (
    <div className="container mt-5">
     <h1 className='text-center mb-4'> Monthly Challenges Reminder</h1> 
     <AddChallenge onChallengeAdded={handleChallengeAdded}/>
     <ChallengesList challenges={challenges} /> 
    </div>
  );
}

export default App;
