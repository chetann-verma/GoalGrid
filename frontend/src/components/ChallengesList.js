import Challenges from "./Challenges";

function ChallengesList({ challenges }) {
  return (
    <div className="list-group">
      {challenges.map(challenge => 
        (
         <Challenges key={challenge.id} challenge={challenge} />
        ))}
    </div>
  );
}
export default ChallengesList;