import Image from "next/image";
import logoFilePath from "./tempLogo.png"
import styles from "./banner.module.css"

const Banner = ({headerText}) => {
    return (
        <header className={"row mb-4 " + styles.banner}>
            <div className="col-5">
                <Image src={logoFilePath} alt="logo" className={styles.logo} />
            </div>
            <div className="col-7 mt-5">
                {headerText}
            </div>
        </header>
    );
};

export default Banner;