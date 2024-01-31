import Image from "next/image";
import logoFilePath from "./ShittyLogo.png"
import styles from "./banner.module.css"

const Banner = () => {
    return (
        <header className="row mb-4">
            <div className="col-5">
                <Image src={logoFilePath} alt="logo" className={styles.logo} />
            </div>
            <div className="col-7 mt-5">
                Magic The Gathering Collector&apos;s App
            </div>
        </header>
    );
};

export default Banner;