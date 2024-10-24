'use client';

import { useRef, useState } from 'react';
import CardListItem from "./cardListItem";

export default function CardList({cardsArr}) {
  const [cards, setCards] = useState(cardsArr);
  const inputEl = useRef(null);
  const onButtonClick = () => {
    inputEl.current.focus();
  }
  
  return(
    <>
      <div className="row mb-2">
            <h5>Cards</h5>
      </div>
      <div className="row mb-2 mt-2 justify-content-md-center">
        <input ref={inputEl} type="text" />
        <button className="btn btn-primary" onClick={onButtonClick}>Search</button>
      </div>
      <table className="table table-hover">
        <thead>
            <tr>
            <td>Card Id</td>
            <td>Card Name</td>
            <td>Image Path</td>
            <td>Rarity</td>
            <td>Artist Name</td>
            <td>Converted Mana Cost</td>
            <td>Power</td>
            <td>Toughness</td>
            <td>Expansion</td>
            <td>Text Box</td>
            <td>Back Card</td>
            </tr>
        </thead>
        <tbody>
            {cards.map((c) => (
                <CardListItem 
                    key={c.cardId} 
                    cardId={c.cardId} 
                    cardName={c.cardName} 
                    imagePath={c.imagePath} 
                    rarity={c.rarity} 
                    artistName={c.artistName} 
                    convertedManaCost={c.convertedManaCost} 
                    power={c.power} 
                    toughness={c.toughness} 
                    expansion={c.expansion}
                    textBox={c.textBox}
                />
            ))}
        </tbody>
      </table>
    </>
  );
};