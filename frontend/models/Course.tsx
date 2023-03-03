import { Section } from "./Section";

export interface Course {
  courseName: string;
  category: string;
  description: string;
  sections: Array<Section>;   
}