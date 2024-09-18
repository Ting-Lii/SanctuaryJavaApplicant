# Sanctuary Management System

## Description
The Sanctuary Management System is a Java-based application designed to efficiently manage a primate sanctuary. It facilitates the registration, isolation, transfer, and monitoring of monkeys, ensuring that all animals are well cared for and housed according to their specific needs. The system includes a user-friendly graphical user interface (GUI), making it accessible for sanctuary staff to manage daily operations effectively.

## Features
- **Register Monkeys**: Allows staff to add new monkeys to the sanctuary's isolation units directly through the GUI.
- **Transfer Monkeys**: Monkeys can be moved from isolation to species-specific enclosures once they pass health checks, ensuring they are placed in suitable habitats.
- **View Enclosures**: Staff can view details of each enclosure, including the monkeys residing there, their sex, species, and favorite food.
- **List All Monkeys**: Provides an alphabetical list of all monkeys currently housed at the sanctuary, accessible via the GUI.

## How To Run
### Executable Jar
To run the application, use the following command:
java -jar SanctuaryManagementSystem.jar


## Usage
- **Registering a Monkey**: Navigate to the 'Register' tab in the application, fill in the monkey's details, and submit. The monkey will first be placed in isolation automatically.
- **Transferring a Monkey**: From the 'Isolation List', select a monkey, and use the 'Transfer' button to move them to a designated enclosure based on their species  and health status.
- **Viewing Monkeys**: Information about monkeys can be viewed by selecting the 'Show Enclosure Details' and 'Show Alphabetical List' options in the GUI.

## Design/Model Changes
- **Version 1.0.0**: Initial release of the Sanctuary Management System.

## Assumptions
- The system assumes that all monkeys are given a name and a preliminary health check before being registered in the sanctuary.

## Limitation
- This application is not suitable for distributing native code or libraries.

## Support
For support, technical issues, or further information, please contact the Author Ashley, li.ting4@northeastern.edu

## Citation
GitHub Guides. (n.d.). Mastering Markdown. Retrieved from https://guides.github.com/features/mastering-markdown/