import ExpansionListItem from "../expansions/expansionListItem"
import Image from 'next/image'

const CardListItem = (
    { cardId, cardName, imagePath, rarity, artistName,
         convertedManaCost, power, toughness, expansion,
          textBox, backCard }) => {
    return(
        <tr>
            <td>{cardId}</td>
            <td>{cardName}</td>
            <td>{imagePath}</td>
            <td>
                <Image
                    src={`/` + imagePath}
                    width={200}
                    height={300}
                    alt={cardName}
                />
            </td>
            <td>{rarity}</td>
            <td>{artistName}</td>
            <td>{convertedManaCost}</td>
            <td>{power}</td>
            <td>{toughness}</td>
            <td><ExpansionListItem key={expansion.expansionId} {...expansion}/></td>
            <td>{textBox}</td>
            <td>{backCard}</td>
        </tr>
    );
};

export default CardListItem;